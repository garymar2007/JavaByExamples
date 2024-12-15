package org.gary.solid.leskovsubstitution;

public abstract class SocialMedia {

    //@Support WhatsApp, Facebook, Instagram
    public abstract void chatWithFriend();

    //@Support Facebook, Instagram
    public abstract void publishPost(Object post);

    //@Support WhatsApp, Facebook, Instagram
    public abstract void sendPhotosAndVideos();

    //@Support WhatsApp, Facebook
    public abstract void groupVideoCall(String... users);
}
