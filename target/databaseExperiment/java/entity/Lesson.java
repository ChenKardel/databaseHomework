package entity;

public class Lesson implements IEntity
{
    public String lessonNum;
    public String lessonName;
    public String year;
    public String term;
    public int credit;
    public String teacherNum;
    public String beforeLessonNum;
    public Lesson()
    {

    }
    public Lesson(String lessonNum, String lessonName, String year, String term, int credit, String teacherNum, String beforeLessonNum)
    {
        this.lessonNum = lessonNum;
        this.lessonName = lessonName;
        this.year = year;
        this.term = term;
        this.credit = credit;
        this.teacherNum = teacherNum;
        this.beforeLessonNum = beforeLessonNum;
    }

    public String getLessonNum()
    {
        return lessonNum;
    }

    public void setLessonNum(String lessonNum)
    {
        this.lessonNum = lessonNum;
    }

    public String getLessonName()
    {
        return lessonName;
    }

    public void setLessonName(String lessonName)
    {
        this.lessonName = lessonName;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public String getTerm()
    {
        return term;
    }

    public void setTerm(String term)
    {
        this.term = term;
    }

    public int getCredit()
    {
        return credit;
    }

    public void setCredit(int credit)
    {
        this.credit = credit;
    }

    public String getTeacherNum()
    {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum)
    {
        this.teacherNum = teacherNum;
    }

    public String getBeforeLessonNum()
    {
        return beforeLessonNum;
    }

    public void setBeforeLessonNum(String beforeLessonNum)
    {
        this.beforeLessonNum = beforeLessonNum;
    }
}
