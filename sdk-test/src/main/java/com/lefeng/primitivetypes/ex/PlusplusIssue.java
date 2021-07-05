package com.lefeng.primitivetypes.ex;

public class PlusplusIssue {
    public static void main(String[] args) {
        int i = 0;
        int j = i++;
        System.out.println(i);
        System.out.println(j);

        int i1 = 0;
        i1 = ++i1;
        System.out.println(i1);

        int i2 = 0;
        i2 = i2++;
        System.out.println(i2);
        //�����ִ��˳���������ģ���Ϊ++�ں��棬������ʹ��i����ʹ�á��ĺ������i++������ʽ��ֵ��0�����ǲ�û������ֵ������
        // ��������������������ֵ��Ҳ����˵������++�������ٸ�ֵ�ģ��������ս������0
        //{code}
        //      int temp = i;       //���temp����i++������ʽ��ֵ
        //      i++;                //i����
        //      i = temp;           //���գ������ʽ��ֵ��ֵ��i
        //{code}
    }
}
