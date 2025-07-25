import java.util.ArrayList;

public class Post {
    private String title;
    private String content;
    private Post replyTo;
    private User author;
    private int upvoteCount;
    private int downvoteCount;
    public Post(String title, String content, User author){
        this.title=title;
        this.content=content;
        this.replyTo=null;
        this.author=author;
        upvoteCount=1;
        downvoteCount=0;
        //
    }

    public Post(String content, Post replyTo, User author){
        this.title=null;
        this.content=content;
        this.author=author;
        this.replyTo=replyTo;
        this.upvoteCount=1;
        this.downvoteCount=0;
        //
    }

    public String getTitle(){
        Post current = this;
    while (current.replyTo != null) {
        current = current.replyTo;
    }
    return current.title;
    }
        

    public Post getReplyTo(){
        return this.replyTo;
        //
    }

    public User getAuthor(){
        return this.author;
        //
    }

    public int getUpvoteCount(){
        return this.upvoteCount;
        //
    }

    public int getDownvoteCount(){
        return this.downvoteCount;
        //
    }

    public void updateUpvoteCount(boolean isIncrement){
        if(isIncrement==true){
            this.upvoteCount+=1;
        }
        else{
            this.upvoteCount-=1;
        }
        //
    }

    public void updateDownvoteCount(boolean isIncrement){
        if(isIncrement==true){
            this.downvoteCount+=1;
        }
        else{
            this.downvoteCount-=1;
        }
        //
    }

    public ArrayList<Post> getThread(){
        ArrayList<Post> thread = new ArrayList<>();
        Post current = this;
        while (current != null) {
        thread.add(0, current); 
        current = current.getReplyTo();
    }
    return thread;
        
    }

    public String toString(){
        String k="";
        k="["+upvoteCount+"|"+downvoteCount+"]\t";
        if(this.title!=null){
        k+=this.title+"\n\t" + this.content;
        }
        else{
        k+=this.content;
        }
        return k;
    }

}
