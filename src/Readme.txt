To connect Java application with the anySql database we need to follow 5 steps
    -> Load the driver class
    -> Create connection using Driver manager
    -> Use connection to fire queries {Statement for static queries and PreparedStatement for dynamic queries(parameterized queries)}
        => select * from table (static)
        => select * from table where col=? (dynamic query)
    ->Process the result .
        => ResultSet ->
    -> Close the connection


    => => => Student Management App => => =>
