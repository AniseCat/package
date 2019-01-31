package service;

import java.util.ArrayList;

public interface AdminService {

    /*
     *审批课程（开课申请）
     */
    public ArrayList getApplyList();

    /*
     *审批课程（创建课程申请）
     */
    public boolean approveLecture(int lectureId);


    /*
     *审批课程（创建课程申请）
     */
    public boolean declineLecture(int lectureId);

    /*
     *审批课程（开课申请）
     */
    public boolean approveCourse(int courseId);

    /*
     *审批课程（开课申请）
     */
    public boolean declineCourse(int courseId);

    /*
     *获取老师信息，便于图表显示
     */
    public ArrayList getTeacherInfo();

    /*
     *获取学生信息，便于图表显示
     */
    public ArrayList getStudentInfo();

    /*
     * 获取论坛使用情况，便于图表显示
     * 暂定为获取前一天的 上传/下载量 论坛发言条数 在线人数等等
     */
    public ArrayList getForumUsageInfo();

}
