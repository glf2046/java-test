package case_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 有20个账户，每个账户1000块
 * 10个线程，每次取随机的两个账户进行转账,每次转100以内的正整数
 * 每个线程执行100次转账操作
 * 最后打印每个账户的剩余金额
 */
public class AccountTransfer {
    public static void main(String[] args) throws Exception {
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            accounts.add(new Account(String.valueOf(i), 1000));
        }

        for (int i = 0; i < 200; i++) {
            testTransfer(accounts);
        }
    }

    private static void testTransfer(List<Account> accounts) throws Exception {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 300; i++) {
            Thread thread = new Thread(new Task(accounts));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

//        accounts.forEach((account -> System.out.println(account.getAccountId() + ": " + account.getBalance())));

        int sum = accounts.parallelStream().map(Account::getBalance).reduce(0, Integer::sum);
        System.out.println(sum);
        if (sum != 20000) {
            throw new Exception("not equal 20000");
        }
    }

}

class Task implements Runnable {
    List<Account> accounts;
    int runTimes;
    Random random = ThreadLocalRandom.current();

    public Task(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void run() {
        while (runTimes++ < 10) {
//            System.out.println("threadid: " + Thread.currentThread().getId() + ", runTimes: " + runTimes);
//            final Account from = accounts.get(0);
//            final Account to = accounts.get(1);

            final Account from = accounts.get(Math.abs(random.nextInt() % 20));
            final Account to = accounts.get(Math.abs(random.nextInt() % 20));

            int amt = Math.abs(random.nextInt() % 100);
            //这个地方也可以使用ReentrantLock.tryLock(10ms)等，这样如果发生死锁，可以超时释放
            if (from.getAccountId().compareToIgnoreCase(to.getAccountId()) > 0) {
                lockAndRransfer(to, from, amt);
            } else {
                lockAndRransfer(from, to, amt);
            }
        }
    }

    private void lockAndRransfer(Account from, Account to, int amt) {
        synchronized (to) {
            synchronized (from) {
                if (!from.getAccountId().equalsIgnoreCase(to.getAccountId()) && from.getBalance() > amt) {
//                    System.out.println("threadid: " + Thread.currentThread().getId() + ", from: " + from.getBalance() + ", to: " + to.getBalance());
                    from.setBalance(from.getBalance() - amt);
                    to.setBalance(to.getBalance() + amt);
//                    System.out.println("threadid: " + Thread.currentThread().getId() + ", transferred " + amt + ", from: " + from.getAccountId() + ", to: " + to.getAccountId());
//                    System.out.println("threadid: " + Thread.currentThread().getId() + ", from: " + from.getBalance() + ", to: " + to.getBalance());
                }
            }
//            System.out.println("threadid: " + Thread.currentThread().getId() + ", ##################################################################");
        }
    }
}

class Account {
    private String accountId;
    private int balance;

    public Account(String accountId, int balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
