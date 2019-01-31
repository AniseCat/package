package Model;

import java.sql.Timestamp;

public class Post {
    //帖子ID
    int postId;
    //发帖人姓名
    String username;
    //标题
    String title;
    //时间
    Timestamp time;
    //内容
    String content;

    public int getPostid() {
        return postId;
    }

    public void setPostid(int postid) {
        this.postId = postid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", time=" + time +
                ", content='" + content + '\'' +
                '}';
    }
}
