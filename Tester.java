public class Tester {
    public static void main(String[] args) {
        User u1 = new User("CSE11Student");
        User u2 = new User("AnotherUser");
        Post p1 = new Post("Title", "Content", u1);
        Post c1 = new Post("Comment", p1, u1);
        Post c2 = new Post("Another comment", p1, u2);

        System.out.println(u1);
        System.out.println(p1);
        System.out.println(c1);

       
        u1.addPost(p1);
        u1.addPost(c1);
        u2.addPost(c2);

        System.out.println("Thread for c1:");
        for (Post post : c1.getThread()) {
            System.out.println(post);
        }

        u2.upvote(p1);
        u2.downvote(c1);
        u1.upvote(c2);  
        u1.downvote(c2);  

        System.out.println("u1 Karma: " + u1.getKarma());
        System.out.println("u2 Karma: " + u2.getKarma());

        System.out.println("p1: " + p1.getUpvoteCount() + " upvotes, " + p1.getDownvoteCount() + " downvotes");
        System.out.println("c1: " + c1.getUpvoteCount() + " upvotes, " + c1.getDownvoteCount() + " downvotes");
        System.out.println("c2: " + c2.getUpvoteCount() + " upvotes, " + c2.getDownvoteCount() + " downvotes");

        System.out.println("u1's Top Post: " + u1.getTopPost());
        System.out.println("u1's Top Comment: " + u1.getTopComment());

        System.out.println("Title of p1: " + p1.getTitle());
        System.out.println("Author of c1: " + c1.getAuthor());
        System.out.println("ReplyTo of c1: " + c1.getReplyTo());

        p1.updateUpvoteCount(false);
        p1.updateDownvoteCount(true);
        System.out.println(p1);
    }
}
