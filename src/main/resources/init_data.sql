INSERT INTO public.organization
 (
 org_name ,
    org_phone ,
    org_address ,
    country ,
    city ,
    is_active,
    aria_of_activity,
    number_of_offices,
    region
 )
VALUES
('TheCoon', '+380505556677', 'Kharkov', 'Ukraine', 'Kharkov', true, 'IT', 3, 'EUROPE' ),
('Raccoon', '+380505556678', 'Stoсkholm', 'Sweden', 'Stoсkholm', true, 'Production', 4, 'EUROPE'),
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
(2, 'John', 'Smit', 'Consultant', false, 3),
(3, 'Marry', 'Dick', 'Actress', true, 1);