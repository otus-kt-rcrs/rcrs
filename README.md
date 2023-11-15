# rcrs
This is project for otus

## crm
Customer Relationship Management is a system for an analytical platform where information is collected and then analyzed, namely, information is collected from sources about interested users in certain services. The purpose is to offer users more favorable conditions.

### mvp 
![crm-mvp.png](docs%2Fimgs%2Fcrm-mvp.png)

As part of this architecture, a user-profile-service will be implemented where user analytics will be performed.

#### User Table
| Field      | Type         | Description                |
|------------|--------------|----------------------------|
| id         | int          | User ID                    |
| first_name | varchar(255) | User's first name          |
| last_name  | varchar(255) | User's last name           |
| email      | varchar(255) | User's email address       |
| created    | datetime     | Date and time of creation  |
| updated    | datetime     | Date and time of last update |

#### Profile Table
| Field      | Type         | Description                |
|------------|--------------|----------------------------|
| id         | int          | Profile ID                 |
| user_id    | int          | Foreign key to User table  |
| order      | varchar(255) | Order details              |
| order_date | datetime     | Date and time of the order |
| ...        | ...          | ...                        |

In the above tables, the User table represents basic user information, while the Profile table contains more detailed information about the user, including their orders.

e2e tests using cucumber will be performed

The target audience will be the business itself, with the help of this system will be able to make more flexible decisions to improve the