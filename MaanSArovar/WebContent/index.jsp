<!DOCTYPE html>
<html>
<head>
    <title>Simple Interest Calculator</title>
</head>
<body>
    <h1>Simple Interest Calculator</h1>
    <form action="CustomerController" method="post">
        <label for="customerName">Customer Name:</label>
        <input type="text" id="customerName" name="customerName" required><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br>

        <label for="principleAmount">Principle Amount:</label>
        <input type="number" id="principleAmount" name="principleAmount" required><br>

        <label for="years">Years:</label>
        <input type="number" id="years" name="years" required><br>

        <label for="rate">Rate:</label>
        <input type="number" id="rate" name="rate" required><br>

        <input type="submit" value="Calculate">
    </form>
</body>
</html>
