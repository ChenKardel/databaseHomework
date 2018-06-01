package entity;

import java.util.Date;

public class Message implements IEntity
{
    public long messageNum;
    public String content;
    public long applyNum;
    public String studentNum;
    public Date time;

    public Message()
    {

    }
    public Message(long messageNum, String content, long applyNum, String studentNum, Date time)
    {
        this.messageNum = messageNum;
        this.content = content;
        this.applyNum = applyNum;
        this.studentNum = studentNum;
        this.time = time;
    }

    public long getMessageNum()
    {
        return messageNum;
    }

    public void setMessageNum(long messageNum)
    {
        this.messageNum = messageNum;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public long getApplyNum()
    {
        return applyNum;
    }

    public void setApplyNum(long applyNum)
    {
        this.applyNum = applyNum;
    }

    public String getStudentNum()
    {
        return studentNum;
    }

    public void setStudentNum(String studentNum)
    {
        this.studentNum = studentNum;
    }

    public Date getTime()
    {
        return time;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }
}
