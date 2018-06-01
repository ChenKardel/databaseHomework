package entity;

public class StuChooseLesson implements IEntity
{
    public String studentNum;
    public String lessonNum;
    public StuChooseLesson()
    {
    }



    public StuChooseLesson(String studentNum, String lessonNum)
    {
        this.studentNum = studentNum;
        this.lessonNum = lessonNum;
    }

    public String getLessonNum()
    {
        return lessonNum;
    }

    public void setLessonNum(String lessonNum)
    {
        this.lessonNum = lessonNum;
    }

    public String getStudentNum()
    {
        return studentNum;
    }

    public void setStudentNum(String studentNum)
    {
        this.studentNum = studentNum;
    }

    @Override
    public String toString()
    {
        return "[SCL: " + getLessonNum() + "-" + getStudentNum()+"]";
    }
}
