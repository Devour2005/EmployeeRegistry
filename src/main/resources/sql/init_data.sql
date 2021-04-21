INSERT INTO public.organization
 (
 org_name ,
    org_phone ,
    org_address ,
    country ,
    city ,
    is_active,
    area_of_activity,
    number_of_offices,
    region
 )
VALUES
('TheCoon', '+380505556677', 'Kharkov', 'Ukraine', 'Kharkov', true, 'IT', 3, 'EUROPE' ),
('Raccoon', '+380505556678', 'Stockholm', 'Sweden', 'Stockholm', true, 'Production', 4, 'EUROPE'),
('FatCat', '+380505556679', 'New-York', 'USA', 'New-York', false, 'Video', 1, 'AMERICA');


INSERT INTO public.employee
(
    org_id,
    first_name,
    last_name,
    emp_position,
    is_married,
    years_in_company
)
VALUES
(1, 'Raccoon', 'Tail', 'Developer', false, 5),
(1, 'Silly', 'Fox', 'PM', true, 5),
(1, 'Frant', 'Postman', 'Admin', false, 7),
(1, 'Ben', 'Stanny', 'Admin', false, 7),
(2, 'John', 'Smit', 'Consultant', false, 3),
(2, 'Rac', 'TailTe', 'Developer', false, 2),
(2, 'Marry', 'Gran', 'Developer', false, 6),
(3, 'Jane', 'Fire', 'Act', false, 4),
(3, 'Fat', 'Cat', 'Cook', false, 8),
(3, 'Mike', 'Dick', 'DevOps', true, 1),
(3, 'Den', 'Gran', 'Developer', true, 2);