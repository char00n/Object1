INSERT INTO mmc_users(user_pass,  user_email, user_security_answer,
                      user_full_Name, user_birth_Day,
					  user_gender, user_city, user_icq_number ) VALUES
					  ('12345', 'char@on.ua', 'answer',
					  'Slava', '1983-03-25',
					   'M', 'Yalta', '1234567890');



SELECT
    char_name, char_birth_day, char_gender,
    char_stat_strength, char_stat_strength_total,
    char_stat_endurance, char_stat_endurance_total,
    char_stat_accuracy, char_stat_accuracy_total,
    char_stat_dexterity, char_stat_dexterity_total,
    char_stat_cur_health, char_stat_max_health, char_stat_unused_points
FROM mmc_character
WHERE char_user_id = ?;



