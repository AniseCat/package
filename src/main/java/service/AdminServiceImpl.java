package service;

import Model.Apply;
import Model.Course;
import Model.Lecture;
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
        ArrayList list = new ArrayList();
        for(int i = 0; i < lectureList.size(); i++){
            list.add(changeToApply((Lecture)lectureList.get(i)));
        }
        for(int i = 0; i < courseList.size(); i++){
            list.add(changeToApply((Course)courseList.get(i)));
        }
        return list;
    }

    public Apply changeToApply(Lecture lecture){
        Apply apply = new Apply();
        apply.setType("建课申请");
        apply.setId(lecture.getLectureid());
        apply.setName(lecture.getName());
        apply.setMail(lecture.getTeacherId());
        apply.setStudentNum(0);
        apply.setTerm(null);
        return apply;

    }

    public Apply changeToApply(Course course){
        Apply apply = new Apply();
        apply.setType("开课申请");
        apply.setId(course.getCourseId());
        apply.setName(course.getLecture().getName());
        apply.setMail(course.getLecture().getTeacherId());
        apply.setStudentNum(course.getStudentNum());
        apply.setTerm(course.getTerm());
        return apply;
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
    //TODO
    public ArrayList getForumUsageInfo(){
        ArrayList list = new ArrayList();
        return list;
    }

}
