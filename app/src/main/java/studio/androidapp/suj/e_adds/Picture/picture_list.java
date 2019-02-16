package studio.androidapp.suj.e_adds.Picture;

import android.view.Menu;

public class picture_list {
    private String id,title,image,cost,client,audio_name,video_name;

    public picture_list(){};
    public picture_list(String id, String title, String image, String cost, String client) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.cost = cost;
        this.client = client;
    }

    public String getAudio() {
        return audio_name;
    }
    public void setAudio(String audio_name){
        this.audio_name= audio_name;
    }
    public String getVideo() {
        return video_name;
    }
    public void setVideo(String video_name){
        this.video_name= video_name;
    }
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getCost() {
        return cost;
    }




    public String getClient() {
        return client;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setClient(String client) {
        this.client = client;
    }


}
