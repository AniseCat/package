package Model;

import java.sql.Timestamp;

public class PostItem {
    //帖子ID
    int postId;
    //id
    int itemId;
    //是否为回帖,如果不是,为null
    int parentId;
    //内容
    String content;
    //姓名
    String username;
    //时间
    Timestamp time;

    public PostItem(){

    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PostItem{" +
                "postId=" + postId +
                ", itemId=" + itemId +
                ", parentId=" + parentId +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", time=" + time +
                '}';
    }
}
