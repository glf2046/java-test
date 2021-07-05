当做输入输出的时候，输入输出的格式要匹配，如果期待读取的是一定格式，那么输入要满足这个格式。

Clearly you aren't sending the data with ObjectOutputStream: you are just writing the bytes.

If you read with readObject() you must write with writeObject().
If you read with readUTF() you must write with writeUTF().
If you read with readXXX() you must write with writeXXX(), for most values of XXX.