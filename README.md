# MediCare - Medicine Shopping App

## Description

MediCare is a comprehensive medicine shopping application designed to provide users with a seamless experience in purchasing medicines and healthcare products.
Built on a Spring Boot backend, this application offers a range of functionalities to cater to the diverse needs of users looking for medicinal products.
## BASE IP ADDRESS :[https://medicare.up.railway.app/](https://medicare.up.railway.app/api/Public/getItem)
## Features

- **User Authentication**: Register new users and authenticate login credentials securely.
- **Browse Medicines**: Access a wide range of medicines with detailed information.
- **Product Details**: View comprehensive details of each medicine, including dosage, price, and availability.
- **Shopping Cart**: Add, update, or remove items from the cart for easy purchasing.
- **Checkout Process**: Secure payment gateways and order confirmation.

## REST API Endpoints

### Authentication

- `/api/auth/signup` - POST: Register a new user.
- `/api/auth/signin` - POST: User login to the application.
- `/api/auth/forget_password` - POST: Request to reset the password.
- `/api/auth/verify_OTP` - POST: Verify the One-Time Password (OTP) for password reset.
- `/api/auth/update_Password` - POST: Update the password after successful verification.

### Product Admin Endpoints

#### Add Item
- **POST `/api/Admin/create`**
    - Description: Add a new item to the database.
    - Method: `POST`
    - Body: `Product` object with item details.

#### Update Item
- **PUT `/api/Admin/update`**
    - Description: Update item data in the database.
    - Method: `PUT`
    - Body: `ProductRequest` object with item ID and updated details.

#### Delete Item
- **POST `/api/Admin/delete`**
    - Description: Delete an item from the database.
    - Method: `POST`
    - Body: `ProductRequest` object with item ID.

### Product User

#### Get All Items
- **GET `/api/Public/getItem`**
    - Description: Retrieve all items from the database.
    - Method: `GET`

#### Filter by Discount
- **GET `/api/Public/filterByDiscount`**
    - Description: Filter products by a specific discount percentage.
    - Method: `GET`
    - Parameters:
        - `discount` (double): Discount percentage.

#### Filter Product by Discount
- **GET `/api/Public/filterProductByDiscount`**
    - Description: Filter a particular product by a specific discount percentage.
    - Method: `GET`
    - Parameters:
        - `discount` (double): Discount percentage.
        - `product` (string): Name of the product.

#### Filter by Category
- **GET `/api/Public/filterByCategory`**
    - Description: Filter products by category.
    - Method: `GET`
    - Parameters:
        - `category` (string): Category name.

#### Filter by Range Discount
- **GET `/api/Public/filterByRangeDiscount`**
    - Description: Filter products by a range of discount percentages.
    - Method: `GET`
    - Parameters:
        - `minDiscount` (double): Minimum discount percentage.
        - `maxDiscount` (double): Maximum discount percentage.

#### Filter Product by Range Discount
- **GET `/api/Public/filterProductByRangeDiscount`**
    - Description: Filter a particular product by a range of discount percentages.
    - Method: `GET`
    - Parameters:
        - `minDiscount` (double): Minimum discount percentage.
        - `maxDiscount` (double): Maximum discount percentage.
        - `product` (string): Name of the product.

#### Filter by Popularity
- **GET `/api/Public/filterByPopularity`**
    - Description: Filter products by popularity (based on the number of buyers).
    - Method: `GET`

#### Filter Product by Popularity
- **GET `/api/Public/filterProductByPopularity`**
    - Description: Filter a particular product by popularity (based on the number of buyers).
    - Method: `GET`
    - Parameters:
        - `product` (string): Name of the product.


### Cart

#### Add to Cart
- **POST `/api/addCart`**
    - Description: Add an item to the cart.
    - Method: `POST`
    - Body: `CartRequest` object with item ID, username, and quantity.

#### Delete Cart Item
- **PUT `/api/deleteCartItem`**
    - Description: Remove an item from the cart.
    - Method: `PUT`
    - Parameters:
        - `cartId` (string): Cart item ID.

#### Increase Item Quantity in Cart
- **PUT `/api/increaseItemInCart`**
    - Description: Increase the quantity of an item in the cart.
    - Method: `PUT`
    - Parameters:
        - `cartId` (string): Cart item ID.
        - `increment` (int): Quantity to increment.

#### Decrease Item Quantity in Cart
- **PUT `/api/decreaseItemInCart`**
    - Description: Decrease the quantity of an item in the cart.
    - Method: `PUT`
    - Parameters:
        - `cartId` (string): Cart item ID.
        - `decrement` (int): Quantity to decrement.
#### Remove All Items from Cart

- **PUT `/api/removeCart`**
  - Description: Endpoint to remove all items from the cart.
  - Method: PUT
  - Parameters:
      - `cartId` (string): Cart item ID.
  - Response: Returns a message response indicating the success of the operation.
      - `200 OK` with the message response body.

#### Get Cart Items
- **GET `/api/getCart`**
    - Description: Retrieve cart items for a specific user.
    - Method: `GET`
    - Parameters:
        - `userId` (string): UserId to fetch cart items.

### Orders

#### Buy Product
- **POST `/api/order`**
    - Description: Buy a product and create an order.
    - Method: `POST`
    - Body: `OrderRequest` object with item ID, quantity, user details, and order information.
#### Buy Product History
- **GET `/api/showOrder/{userId}`**
    - Description: Show the products that bought by user.
    - Method: `GET`
  - Path Variable:
      - `userId` (string): UserId to fetch cart items.
### Payment 

#### Create Payment Link

- **POST `/api/payment/{orderId}`**
  - Description: Endpoint to create a payment link for the specified order.
  - Method: POST
  - Path Variable:
      - `orderId` (string): The ID of the order for which the payment link is to be created.
  - Request Body: None
  - Response: Returns a payment link response containing the payment link ID and URL.
      - `201 Created` with the payment link response body.

#### Update Payment

- **PUT `/api/payment/updatePayment`**
  - Description: Endpoint to update the payment status for an order.
  - Method: PUT
  - Parameters:
      - `payment_id` (string): The ID of the payment.
      - `order_id` (string): The ID of the order associated with the payment.
  - Response: Returns an update payment response indicating the success of the operation.
      - `200 OK` with the update payment response body.
    
## Security

- Token-based authentication ensuring secure user access.
- Consistent error handling for invalid requests and security breaches.

## Error Handling

- Utilization of appropriate HTTP status codes for error responses.
- Clear and descriptive error messages for enhanced user understanding.

## Technologies Used

- **Spring Boot**: Backend framework for robust application development.
- **Java**: Primary programming language for implementing backend logic.
- **RESTful APIs**: Architecture for communication between client and server.
- **MongoDB**: No SQL Database management systems for data storage.
- **Spring Security**: Implementation of security features and authentication.

## Setup Instructions

1. **Clone Repository**: Clone the repository from GitHub.
2. **Configure Database**: Set up a MongoDB database and configure database properties in `application.properties`.
3. **Run Application**: Use Maven to build and run the Spring Boot application.
4. **Access Endpoints**: Utilize the provided endpoints for various functionalities.

## Usage

1. **Register/Login**: Create a new account or log in using existing credentials.
2. **Browse Medicines**: Explore available medicines and view details.
3. **Add to Cart**: Select desired medicines and add them to the cart.
4. **Checkout**: Complete the purchase process by placing an order securely.

## Contributing

Contributions are most welcome!
If you'd like to contribute to the project,
please fork the repository and create a pull request.



