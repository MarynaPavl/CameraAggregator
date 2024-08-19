# CameraAggregator
  Aggregating Camera Data from Multiple Services using Reactive Programming in Java
  Objective: develop a Java application that retrieves and aggregates data from multiple external services, ensuring efficient handling of potentially large datasets by leveraging reactive programming principles.
  Project Overview: the project involves creating a service that fetches data about available video cameras from an external API, which provides a list of cameras with their respective data sources and security tokens. The service aggregates these details into a single output for each camera, optimizing the process using multithreading and minimizing I/O blocking.
Data Retrieval:
Camera List Endpoint:
URL:https://run.mocky.io/v3/acc75ac0-84fd-4d6c-9443-4155e5604d4d
Response: A JSON array of objects, each containing:
id: The camera's unique identifier.
sourceDataUrl: URL to retrieve the source data.
tokenDataUrl: URL to retrieve security tokens.
Source Data Endpoint:
Data Structure:
urlType: String indicating the type of video stream (e.g., "LIVE", "ARCHIVE").
videoUrl: String containing the URL of the video stream.
Token Data Endpoint:
Data Structure:
value: String representing the security token.
ttl: Integer indicating the token's time-to-live in seconds.
Aggregated Output: json.
Key Features:
Reactive Programming: The application uses the WebClient and Reactor libraries to perform non-blocking I/O operations, enabling efficient data retrieval and processing.
Concurrency: Aggregation is performed across multiple threads to handle large datasets and improve performance.
Error Handling: Graceful handling of errors during data retrieval ensures the application remains resilient.
This project demonstrates the practical use of reactive programming in Java to handle real-world scenarios involving multiple service calls, aggregation, and data processing, making it ideal for scenarios with high data volume and real-time processing requirements.
