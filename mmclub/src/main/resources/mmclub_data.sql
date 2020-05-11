INSERT INTO mmc_users(user_pass,  user_email, user_security_answer,
                      user_full_Name, user_birth_Day,
					  user_gender, user_city, user_icq_number ) VALUES
					  ('12345', 'char@on.ua', 'answer',
					  'Slava', '1983-03-25',
					   'M', 'Yalta', '1234567890');


SELECT Nick_Name, User_Pass, SessionID,  User_EMail, Security_Answer,
       Full_Name, User_Birth_Day, Character_Birth_Day, User_Gender,
       User_City, ICQ_Number
FROM mmc_users
WHERE Nick_Name = ? AND User_Pass = ?;



