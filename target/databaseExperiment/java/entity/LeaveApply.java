package entity;

import java.util.Date;

public class LeaveApply implements IEntity
{
    public long applyNum;
    public Date applyTime;
    public String reason;
    public String state;
    public String studentNum;
    public String lessonNum;
    public String teacherNum;

    public LeaveApply()
    {

    }
    public LeaveApply(long applyNum, Date applyTime, String reason, String state, String studentNum, String lessonNum, String teacherNum)
    {
        this.applyNum = applyNum;
        this.applyTime = applyTime;
        this.reason = reason;
        this.state = state;
        this.studentNum = studentNum;
        this.lessonNum = lessonNum;
        this.teacherNum = teacherNum;
    }

    public long getApplyNum()
    {
        return applyNum;
    }

    public void setApplyNum(long applyNum)
    {
        this.applyNum = applyNum;
    }

    public Date getApplyTime()
    {
        return applyTime;
    }

    public void setApplyTime(Date applyTime)
    {
        this.applyTime = applyTime;
    }

    public String getReason()
    {
        return reason;
    }

    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getStudentNum()
    {
        return studentNum;
    }

    public void setStudentNum(String studentNum)
    {
        this.studentNum = studentNum;
    }

    public String getLessonNum()
    {
        return lessonNum;
    }

    public void setLessonNum(String lessonNum)
    {
        this.lessonNum = lessonNum;
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
