
import java.util.ArrayList;

public class User {
     private int karma;
    private String username;
    private ArrayList<Post> posts;
    private ArrayList<Post> upvoted;
    private ArrayList<Post> downvoted;
    

    public User(String username){
        this.username=username;
        this.karma=0;
        this.posts = new ArrayList<>();
        this.upvoted = new ArrayList<>();
        this.downvoted = new ArrayList<>();
    }

    public void addPost(Post post){
        if(post!=null){
        posts.add(post);
        }
        updateKarma();

    }

    public void updateKarma(){
        int k=0;
        Post p=null;
        for(int i=posts.size()-1;i>=0;i--){
            p=posts.get(i);
            k=k+p.getUpvoteCount()-p.getDownvoteCount();
        }
        this.karma=k;
    }

    public int getKarma(){
        int k=0;
        for(int i=posts.size()-1;i>=0;i--){
            k=k+(posts.get(i)).getUpvoteCount()-(posts.get(i)).getDownvoteCount();
        }
        return k;
        
    }



    public void upvote(Post post){
        if(post==null){
            return;
        }
        for(int i=upvoted.size()-1;i>=0;i--){
            if(upvoted.get(i)==post)
            return;
        }
        for(int i=downvoted.size()-1;i>=0;i--){
            if(downvoted.get(i)==post){
                downvoted.remove(i);
                post.updateDownvoteCount(false);
            }
        }
        upvoted.add(post);
        post.updateUpvoteCount(true);
        (post.getAuthor()).updateKarma();
    }


    public void downvote(Post post){
        if(post==null){
            return;
        }
        for(int i=downvoted.size()-1;i>=0;i--){
            if (downvoted.get(i) == post) 
            return;
            
        }
         for(int i=upvoted.size()-1;i>=0;i--){
            if(upvoted.get(i)==post){
                upvoted.remove(i);
                post.updateUpvoteCount(false);
            }
        }
        downvoted.add(post);
        post.updateDownvoteCount(true);
        (post.getAuthor()).updateKarma();
    }

    public Post getTopPost(){
        Post k=posts.get(0);
        for(int i=posts.size()-1;i>=0;i--){
            if(posts.get(i).getUpvoteCount()-posts.get(i).getDownvoteCount()>=k.getUpvoteCount()-k.getUpvoteCount())
            k=posts.get(i);
        }
        
        return k;
    }

    public Post getTopComment(){
        Post a=null;
        for(int i=posts.size()-1;i>=0;i--){
            for(int k=posts.get(i).getThread().size()-1;k>=0;k--){
                if(a==null||posts.get(i).getThread().get(k).getUpvoteCount()-posts.get(i).getThread().get(k).getDownvoteCount()>=a.getUpvoteCount()-a.getDownvoteCount()){
                    a=posts.get(i).getThread().get(k);
                }
            }
        }
        return a;
    }

    public ArrayList<Post> getPosts(){
        return this.posts;
    }

    public String toString(){
        return ("u/"+this.username+" "+this.karma);
    }
}
