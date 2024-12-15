package org.gary.solid.leskovsubstitution.solution;

public class Instagram implements ISocialMedia, IPostMediaManger {
    @Override
    public void chatWithFriend() {
        System.out.println("Chatting with friend on Instagram");
    }

    @Override
    public void sendPhotosAndVideos() {
        System.out.println("Sending photos and videos on Instagram");
    }

    @Override
    public void publishPost(Object post) {
        System.out.println("Publishing post on Instagram");
    }
}
