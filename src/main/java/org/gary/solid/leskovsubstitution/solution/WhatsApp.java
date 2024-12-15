package org.gary.solid.leskovsubstitution.solution;

public class WhatsApp implements ISocialMedia, ISocialVideoCallManager {
    @Override
    public void chatWithFriend() {
        System.out.println("Chatting with friend on WhatsApp");
    }

    @Override
    public void sendPhotosAndVideos() {
        System.out.println("Sending photos and videos on WhatsApp");
    }

    @Override
    public void groupVideoCall(String... users) {
        System.out.println("Group video call on WhatsApp");
    }
}
