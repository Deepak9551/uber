
ALTER TABLE review
    ADD booking_id BIGINT NULL;

ALTER TABLE review
    MODIFY booking_id BIGINT NOT NULL;

ALTER TABLE review
    ADD CONSTRAINT uc_review_booking UNIQUE (booking_id);



ALTER TABLE review
    ADD CONSTRAINT FK_REVIEW_ON_BOOKING FOREIGN KEY (booking_id) REFERENCES booking (id);

