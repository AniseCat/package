package service;

import dao.AdminDaoImpl;

import java.util.ArrayList;

public class AdminServiceImpl implements AdminService {

    AdminDaoImpl adminDao = new AdminDaoImpl();
    /*
     *审批课程（开课申请）
     */
    public ArrayList getApplyList(){
        ArrayList lectureList = adminDao.getLectureApply();
        ArrayList courseList = adminDao.getCourseApply();
        ??
        ArrayList list = new ArrayList();
        return list;
    }

    /*
     *审批课程（创建课程申请）
     */
    public boolean approveLecture(int lectureId){
        return adminDao.setLectureValid(lectureId);
    }


    /*
     *审批课程（创建课程申请）
     */
    public boolean declineLecture(int lectureId){
        return adminDao.deleteLecture(lectureId);
    }

    /*
     *审批课程（开课申请）
     */
    public boolean approveCourse(int courseId){
        return adminDao.setCourseValid(courseId);
    }

    /*
     *审批课程（开课申请）
     */
    public boolean declineCourse(int courseId){
        return adminDao.deleteCourse(courseId);
    }

    /*
     *获取老师信息，便于图表显示
     */
    public ArrayList getTeacherInfo(){
        return adminDao.getTeacherList();
    }

    /*
     *获取学生信息，便于图表显示
     */
    public ArrayList getStudentInfo(){
        return adminDao.getStudentList();
    }

    /*
     * 获取论坛使用情况，便于图表显示
     * 暂定为获取前一天的 上传/下载量 论坛发言条数 在线人数等等
     */
    public ArrayList getForumUsageInfo(){
        ArrayList list = new ArrayList();
        ??
        return list;
    }

}
