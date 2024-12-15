package org.gary.solid.leskovsubstitution.solution;

/**
 * This is to demosntrate the Liskov Substitution Principle:
 * In this example where some implementations of socialMedia class do not support all the methods.
 */
public interface ISocialMedia {
    public void chatWithFriend();

    public void sendPhotosAndVideos();
}
