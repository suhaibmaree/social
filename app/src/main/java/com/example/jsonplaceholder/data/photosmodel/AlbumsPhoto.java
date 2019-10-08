package com.example.jsonplaceholder.data.photosmodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "albumId",
        "id",
        "title",
        "url",
        "thumbnailUrl"
})
public class AlbumsPhoto implements Parcelable
{

    @JsonProperty("albumId")
    private Integer albumId;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;
    @JsonProperty("thumbnailUrl")
    private String thumbnailUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Parcelable.Creator<AlbumsPhoto> CREATOR = new Creator<AlbumsPhoto>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AlbumsPhoto createFromParcel(Parcel in) {
            return new AlbumsPhoto(in);
        }

        public AlbumsPhoto[] newArray(int size) {
            return (new AlbumsPhoto[size]);
        }

    }
            ;

    protected AlbumsPhoto(Parcel in) {
        this.albumId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.thumbnailUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
    }

    public AlbumsPhoto() {
    }

    @JsonProperty("albumId")
    public Integer getAlbumId() {
        return albumId;
    }

    @JsonProperty("albumId")
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("thumbnailUrl")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @JsonProperty("thumbnailUrl")
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(albumId);
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(url);
        dest.writeValue(thumbnailUrl);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return 0;
    }

}