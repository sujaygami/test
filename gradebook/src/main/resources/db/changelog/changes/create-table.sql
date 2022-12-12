CREATE TABLE IF NOT EXISTS school (
    school_id VARCHAR(20) NOT NULL,
    name VARCHAR(100),
    CONSTRAINT school_pk PRIMARY KEY (school_id)
);

CREATE TABLE IF NOT EXISTS gb_user (
    gb_user_id VARCHAR(20) NOT NULL,
    school_id VARCHAR(20) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    type VARCHAR(20) NOT NULL,
    CONSTRAINT gb_user_pk PRIMARY KEY (gb_user_id),
    CONSTRAINT gb_user_school_fk FOREIGN KEY (school_id) REFERENCES school(school_id)
);

CREATE TABLE IF NOT EXISTS course (
    course_id VARCHAR(20) NOT NULL,
    name VARCHAR(50),
    school_id VARCHAR(20) NOT NULL,
    CONSTRAINT course_pk PRIMARY KEY (course_id),
    CONSTRAINT course_school_fk FOREIGN KEY (school_id) REFERENCES school(school_id)
);

CREATE TABLE IF NOT EXISTS gb_user_courses (
    course_id VARCHAR(20) NOT NULL,
    gb_user_id VARCHAR(20) NOT NULL,
    CONSTRAINT course_fk FOREIGN KEY (course_id) REFERENCES course(course_id),
    CONSTRAINT gb_user_fk FOREIGN KEY (gb_user_id) REFERENCES gb_user(gb_user_id),
    CONSTRAINT gb_user_courses_pk PRIMARY KEY (course_id, gb_user_id)
);

CREATE TABLE IF NOT EXISTS assignment (
    assignment_id VARCHAR(20) NOT NULL,
    course_id VARCHAR(20) NOT NULL,
    CONSTRAINT assignment_pk PRIMARY KEY (assignment_id),
    CONSTRAINT assignment_course_fk FOREIGN KEY (course_id) REFERENCES course(course_id)
);

CREATE TABLE IF NOT EXISTS assessment (
    assessment_id VARCHAR(20) NOT NULL,
    type VARCHAR(50),
    points_possible INTEGER NOT NULL,
    assignment_id VARCHAR(20) NOT NULL,
    CONSTRAINT assessment_pk PRIMARY KEY (assessment_id),
    CONSTRAINT assessment_assignment_fk FOREIGN KEY (assignment_id) REFERENCES assignment(assignment_id)
);

CREATE TABLE IF NOT EXISTS submission (
    course_id VARCHAR(20) NOT NULL,
    gb_user_id VARCHAR(20) NOT NULL,
    assessment_id VARCHAR(20) NOT NULL,
    dt_submitted TIMESTAMP NOT NULL DEFAULT now(),
    points_earned DECIMAL(5, 2),
    CONSTRAINT submission_gb_user_fk FOREIGN KEY (gb_user_id) REFERENCES gb_user(gb_user_id),
    CONSTRAINT submission_course_fk FOREIGN KEY (course_id) REFERENCES course(course_id),
    CONSTRAINT submission_assessment_fk FOREIGN KEY (assessment_id) REFERENCES assessment(assessment_id),
    CONSTRAINT submission_pk PRIMARY KEY (gb_user_id, assessment_id)
);

-- Populating schools, gb_users, courses, assignments, and assessments based on following instructions:
-- For simplicity’s sake, assume that course roster and course structure are set at the time of first interaction with
-- the Gradebook system.
INSERT INTO school (school_id, name) VALUES
    ('school-001', 'ABC University'),
    ('school-002', 'XYZ University');

INSERT INTO gb_user (gb_user_id, school_id, first_name, last_name, type) VALUES
    ('user-001', 'school-001', 'Sam', 'Johnson', 'student'),
    ('user-002', 'school-001', 'Mike', 'Williams', 'student'),
    ('user-003', 'school-001', 'Kyle', 'Garner', 'student'),
    ('user-004', 'school-001', 'Peter', 'Jennings', 'student'),
    ('user-005', 'school-001', 'James', 'Mason', 'student'),
    ('user-006', 'school-002', 'Daniel', 'Wright', 'student'),
    ('user-007', 'school-002', 'Matt', 'Hunt', 'student'),
    ('user-008', 'school-002', 'Sally', 'Webb', 'student'),
    ('user-009', 'school-002', 'Robin', 'Stone', 'student'),
    ('user-010', 'school-002', 'Kayla', 'Phillips', 'student'),
    ('ins-001', 'school-001', 'Dominic', 'Wellington', 'instructor'),
    ('ins-002', 'school-001', 'Sandra', 'Hopkins', 'instructor'),
    ('ins-003', 'school-002', 'Katie', 'Joyner', 'instructor'),
    ('ins-004', 'school-002', 'Will', 'Knight', 'instructor');

INSERT INTO course (course_id, name, school_id) VALUES
    ('course-001', 'algebra', 'school-001'),
    ('course-002', 'science', 'school-001'),
    ('course-003', 'chemistry', 'school-001'),
    ('course-004', 'biology', 'school-001'),
    ('course-005', 'math', 'school-002'),
    ('course-006', 'geometry', 'school-002'),
    ('course-007', 'nursing', 'school-002'),
    ('course-008', 'engineering', 'school-002');

INSERT INTO gb_user_courses (course_id, gb_user_id) VALUES
    ('course-001', 'user-001'),
    ('course-002', 'user-001'),
    ('course-003', 'user-001'),
    ('course-004', 'user-001'),
    ('course-001', 'user-002'),
    ('course-002', 'user-002'),
    ('course-003', 'user-003'),
    ('course-004', 'user-003'),
    ('course-001', 'user-004'),
    ('course-002', 'user-004'),
    ('course-003', 'user-004'),
    ('course-004', 'user-004'),
    ('course-002', 'user-005'),
    ('course-003', 'user-005'),
    ('course-005', 'user-006'),
    ('course-006', 'user-006'),
    ('course-007', 'user-006'),
    ('course-008', 'user-006'),
    ('course-005', 'user-007'),
    ('course-006', 'user-007'),
    ('course-007', 'user-008'),
    ('course-008', 'user-008'),
    ('course-005', 'user-009'),
    ('course-006', 'user-009'),
    ('course-007', 'user-009'),
    ('course-008', 'user-009'),
    ('course-006', 'user-010'),
    ('course-007', 'user-010');

INSERT INTO assignment (assignment_id, course_id) VALUES
    ('a1', 'course-001'),
    ('a2', 'course-002'),
    ('a3', 'course-002'),
    ('a4', 'course-003'),
    ('a5', 'course-003'),
    ('a6', 'course-003'),
    ('a7', 'course-004'),
    ('a8', 'course-005'),
    ('a9', 'course-005'),
    ('a10', 'course-005'),
    ('a11', 'course-005'),
    ('a12', 'course-006'),
    ('a13', 'course-006'),
    ('a14', 'course-007'),
    ('a15', 'course-007'),
    ('a16', 'course-007'),
    ('a17', 'course-007'),
    ('a18', 'course-008'),
    ('a19', 'course-008'),
    ('a20', 'course-008');

INSERT INTO assessment (assessment_id, type, points_possible, assignment_id) VALUES
     ('asmt1', 'quiz', 100, 'a1'),
     ('asmt2', 'test', 500, 'a1'),
     ('asmt3', 'quiz', 100, 'a2'),
     ('asmt4', 'test', 500, 'a2'),
     ('asmt5', 'quiz', 100, 'a3'),
     ('asmt6', 'test', 500, 'a3'),
     ('asmt7', 'quiz', 100, 'a4'),
     ('asmt8', 'test', 500, 'a4'),
     ('asmt9', 'quiz', 100, 'a5'),
     ('asmt10', 'test', 500, 'a5'),
     ('asmt11', 'quiz', 100, 'a6'),
     ('asmt12', 'test', 500, 'a6'),
     ('asmt13', 'quiz', 100, 'a7'),
     ('asmt14', 'test', 500, 'a7'),
     ('asmt15', 'quiz', 100, 'a8'),
     ('asmt16', 'test', 500, 'a8'),
     ('asmt17', 'quiz', 100, 'a9'),
     ('asmt18', 'test', 500, 'a9'),
     ('asmt19', 'quiz', 100, 'a10'),
     ('asmt20', 'test', 500, 'a10'),
     ('asmt21', 'quiz', 100, 'a11'),
     ('asmt22', 'test', 500, 'a11'),
     ('asmt23', 'test', 500, 'a12'),
     ('asmt24', 'quiz', 100, 'a12'),
     ('asmt25', 'test', 500, 'a13'),
     ('asmt26', 'quiz', 100, 'a13'),
     ('asmt27', 'test', 500, 'a14'),
     ('asmt28', 'quiz', 100, 'a14'),
     ('asmt29', 'test', 500, 'a15'),
     ('asmt30', 'quiz', 100, 'a15'),
     ('asmt31', 'test', 500, 'a16'),
     ('asmt32', 'quiz', 100, 'a16'),
     ('asmt33', 'test', 500, 'a17'),
     ('asmt34', 'quiz', 100, 'a17'),
     ('asmt35', 'test', 500, 'a18'),
     ('asmt36', 'test', 500, 'a18'),
     ('asmt37', 'quiz', 100, 'a19'),
     ('asmt38', 'test', 500, 'a19'),
     ('asmt39', 'quiz', 100, 'a20'),
     ('asmt40', 'test', 500, 'a20');
