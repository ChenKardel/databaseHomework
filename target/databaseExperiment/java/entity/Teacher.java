package entity;

public class Teacher implements IEntity
{
    public String teacherNum;
    public String teacherName;
    public String password;
    public String title;
    public String sex;

    public Teacher()
    {
    }

    public Teacher(String teacherNum, String teacherName, String password, String title, String sex)
    {
        this.teacherNum = teacherNum;
        this.teacherName = teacherName;
        this.password = password;
        this.title = title;
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getTeacherName()
    {
        return teacherName;
    }

    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    public String getTeacherNum()
    {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum)
    {
        this.teacherNum = teacherNum;
    }
}
