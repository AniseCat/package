package util;

import java.util.ArrayList;

public class CourseUtil {

    public ArrayList addIntoCourse(int studentNum, int selectNum){
        ArrayList list = new ArrayList();
        if(selectNum <= selectNum){
            list = addAll(selectNum);
        }
        else{
            list = addRandom(studentNum,selectNum);
        }
        return list;
    }

    public ArrayList addAll(int selectNum){
        ArrayList list = new ArrayList();
        for (int i = 0; i < selectNum; i++){
            list.add(i);
        }
        return list;
    }

    public ArrayList addRandom(int studentNum,int selectNum){

        ArrayList studentList = addAll(selectNum);
        ArrayList list = new ArrayList();
        for(int i = 0; i < selectNum; i++){
            int random = (int)(Math.random() * studentList.size());
            list.add(studentList.get(random));
            studentList.remove(studentList.get(random));
        }
        return list;
    }
}
