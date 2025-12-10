public class OOP_Basics_1{
    public static void main(String[] args){
        Video v1 = new Video("Intro of CODINGKABS", "Codingkabs", "Youtube");
        Video v2 = new Video("part 1 oop", "Codingkabs", "TikTok");
        Video v3 = new Video("i like cricket", "Codingkabs", "Youtube");
        
        v1.printDetails();
        System.out.println(v1.getViews());
        System.out.println("--------------");
        System.out.println("--------------");
        System.out.println("--------------");
        System.out.println("--------------");
        v1.setTitle("Introduction of CK");
        v1.printDetails();
        System.out.println("--------------");

        System.out.println(Video.getVideoCount());
        System.out.println("--------------");

        v1.watch();
        v1.watch();
        v1.watch();
        v1.like();
        v1.like();
        v1.like();
        v1.dislike();
        v1.printDetails();



    }
}


class Video{
     
     private String title;
     private String creatorName;
     private int views;
     private int likes;
     private String platform;
     public static int videoCount= 0;
     
     
     public Video(String title, String creatorName, String platform){
         this.title = title;
         this.creatorName = creatorName;
         this.platform = platform;
         this.likes = 0;
         this.views = 0;
         videoCount++;
     }
     
     public String getTitle(){
         return title;
     }

     public String getCreatorName(){
         return creatorName;
     }
     
     public String getPlatform(){
         return platform;
     }
     
     public int getViews(){
         return views;
     }
     
     public int getLikes(){
         return likes;
     }
     
     // with this since the variable is static this is as well
     // other methods are used on a video ie v1 this is used on the whole class is video
     public static int getVideoCount(){
         return videoCount;
     }
     
     public void setTitle(String new_title){
         if (new_title != null && !new_title.isEmpty()){
                this.title = new_title;
         }
         else{
             System.out.println("Please Enter a Title");
         }
     }
     
     public void setPlatform(String new_platform){
         this.platform = new_platform;
     }
     
     public void setCreatorName(String new_creatorName){
         this.creatorName = new_creatorName;
     }
     
     public void watch(){
         views++;
     }
     
     public void like(){
         likes++;
     }
     
     public void dislike(){
         if (likes > 0){
            likes--;
         }
     }
     
     public void printDetails(){
         System.out.println("Title: " + title);
         System.out.println("Creator: " + creatorName);
         System.out.println("Platform: " + platform);
         System.out.println("Views: " + views);
         System.out.println("Likes: " + likes);


     }
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 

