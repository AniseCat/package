package Model;

import java.sql.Timestamp;

public class PostItem {
    //帖子ID
    int postid;
    //id
    int id;
    //是否为回帖,如果不是,为null
    int parentId;
    //内容
    String content;
    //姓名
    String username;
    //时间
    Timestamp timestamp;

    public PostItem(){

    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostItem{" +
                "postid=" + postid +
                ", id=" + id +
                ", parentId=" + parentId +
                ", content='" + content + '\'' +
                '}';
    }
}
