package com.validtest.shared.application;

import com.validtest.shared.domain.bus.command.Command;

public class ShareDonorExamImageCommand implements Command {

    private String donorId;

    private String imageId;

    private String email;

    private String comment;

    private String imageName;

    private ShareDonorExamImageCommand(String donorId, String imageId, String email, String comment, String imageName) {
        this.donorId = donorId;
        this.imageId = imageId;
        this.email = email;
        this.comment = comment;
        this.imageName = imageName;
    }

    public static ShareDonorExamImageCommand create(String donorId, String imageId, String email, String comment, String imageName) {
        ShareDonorExamImageCommand command = new ShareDonorExamImageCommand(donorId, imageId, email, comment, imageName);
        return command;
    }

    public String donorId() {
        return donorId;
    }

    public String imageId() {
        return imageId;
    }

    public String email() {
        return email;
    }

    public String comment() {
        return comment;
    }

    public String imageName() {
        return imageName;
    }
}
