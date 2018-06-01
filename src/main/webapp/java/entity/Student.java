package entity;

import sun.plugin.viewer.context.IExplorerAppletContext;

public class Student implements IEntity
{
    public String studentNum;
    public String studentName;
    public String sex;
    public int _class;
    public String password;
    public long idCard;

    public Student()
    {
    }

    public Student(String studentNum, String studentName, String sex, int _class, String password, long idCard)
    {
        this.studentNum = studentNum;
        this.studentName = studentName;
        this.sex = sex;
        this._class = _class;
        this.password = password;
        this.idCard = idCard;
    }



    public String getStudentNum()
    {
        return studentNum;
    }

    public void setStudentNum(String studentNum)
    {
        this.studentNum = studentNum;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public int get_class()
    {
        return _class;
    }

    public void set_class(int _class)
    {
        this._class = _class;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public long getIdCard()
    {
        return idCard;
    }

    public void setIdCard(long idCard)
    {
        this.idCard = idCard;
    }


}
