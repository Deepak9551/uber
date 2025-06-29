CREATE TABLE  if not exists booking
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    create_at      datetime              NULL,
    modified_at    datetime              NULL,
    review_id      BIGINT                NULL,
    booking_status ENUM ('SCHEDULED','CANCELLED','CAB_ARRIVED','ASSIGNING_DRIVER','IN_RIDE','COMPLETED' )         NULL,
    start_time     datetime              NULL,
    end_time       datetime              NULL,
    total_distance BIGINT                NOT NULL,
    passenger_id   BIGINT                NULL,
    driver_id      BIGINT                NULL,
    CONSTRAINT pk_booking PRIMARY KEY (id)
);

CREATE TABLE if not exists course_student
(
    course_id  BIGINT NOT NULL,
    student_id BIGINT NOT NULL
);

CREATE TABLE if not exists courses
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    create_at   datetime              NULL,
    modified_at datetime              NULL,
    name        VARCHAR(255)          NULL,
    CONSTRAINT pk_courses PRIMARY KEY (id)
);

CREATE TABLE if not exists courses_students
(
    courses_id  BIGINT NOT NULL,
    students_id BIGINT NOT NULL
);

CREATE TABLE if not exists driver
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    create_at      datetime              NULL,
    modified_at    datetime              NULL,
    name           VARCHAR(255)          NULL,
    license_number VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_driver PRIMARY KEY (id)
);

CREATE TABLE if not exists driver_bookings
(
    driver_id   BIGINT NOT NULL,
    bookings_id BIGINT NOT NULL
);

CREATE TABLE if not exists passenger
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    create_at   datetime              NULL,
    modified_at datetime              NULL,
    content     VARCHAR(255)          NULL,
    rating      VARCHAR(255)          NULL,
    CONSTRAINT pk_passenger PRIMARY KEY (id)
);

CREATE TABLE if not exists passenger_review
(
    id                       BIGINT       NOT NULL,
    passenger_review_content VARCHAR(255) NULL,
    passenger_rating         VARCHAR(255) NULL,
    CONSTRAINT pk_passengerreview PRIMARY KEY (id)
);

CREATE TABLE if not exists review
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    version     INT                   NOT NULL,
    username    VARCHAR(255)          NULL,
    password    VARCHAR(255)          NULL,
    create_at   datetime              NULL,
    modified_at datetime              NULL,
    CONSTRAINT pk_review PRIMARY KEY (id)
);

CREATE TABLE if not exists student
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    create_at   datetime              NULL,
    modified_at datetime              NULL,
    name        VARCHAR(255)          NULL,
    rollno      VARCHAR(255)          NULL,
    CONSTRAINT pk_student PRIMARY KEY (id)
);

ALTER TABLE  driver_bookings
    ADD CONSTRAINT uc_driver_bookings_bookings UNIQUE (bookings_id);

ALTER TABLE driver
    ADD CONSTRAINT uc_driver_licensenumber UNIQUE (license_number);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES driver (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_PASSENGER FOREIGN KEY (passenger_id) REFERENCES passenger (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_REVIEW FOREIGN KEY (review_id) REFERENCES review (id);

ALTER TABLE passenger_review
    ADD CONSTRAINT FK_PASSENGERREVIEW_ON_ID FOREIGN KEY (id) REFERENCES review (id);

ALTER TABLE course_student
    ADD CONSTRAINT fk_coustu_on_courses FOREIGN KEY (course_id) REFERENCES courses (id);

ALTER TABLE courses_students
    ADD CONSTRAINT fk_coustu_on_coursesqpVLbm FOREIGN KEY (courses_id) REFERENCES courses (id);

ALTER TABLE course_student
    ADD CONSTRAINT fk_coustu_on_student FOREIGN KEY (student_id) REFERENCES student (id);

ALTER TABLE courses_students
    ADD CONSTRAINT fk_coustu_on_student0I7ASX FOREIGN KEY (students_id) REFERENCES student (id);

ALTER TABLE driver_bookings
    ADD CONSTRAINT fk_driboo_on_booking FOREIGN KEY (bookings_id) REFERENCES booking (id);

ALTER TABLE driver_bookings
    ADD CONSTRAINT fk_driboo_on_driver FOREIGN KEY (driver_id) REFERENCES driver (id);