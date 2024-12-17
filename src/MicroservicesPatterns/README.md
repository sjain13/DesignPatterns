# Microservices Design Patterns

- [Circuit Breaker](#circuit-breaker)
- [Service Discovery](#service-discovery)
- [API Gateway](#api-gateway)
- [Retry Pattern](#retry-pattern)
- [Bulkhead](#bulkhead)
- [Saga Pattern](#saga-pattern)
- [Event-Driven Architecture](#event-driven-architecture)
- [Strangler Fig](#strangler-fig)

## Circuit Breaker
In a microservices architecture, failures are inevitable. But how do we stop one failure from cascading and impacting the entire system? 🔌 This is where the Circuit Breaker Pattern comes to the rescue! ⚡

### 🔹 What is the Circuit Breaker Pattern?

Just like an electrical circuit breaker, it “breaks” the connection to a failing service to prevent overload and allow the system to recover. It monitors requests and decides when to stop calls temporarily. 🛡️

### 🔹 Why Use Circuit Breakers?

✅ Prevent cascading failures.  
✅ Ensure system resilience and uptime.  
✅ Reduce unnecessary load on struggling or unavailable services.  

### 🔹 How Does It Work?

1️⃣ **Closed State** – All requests are allowed until a threshold of failures is reached.  
2️⃣ **Open State** – Requests are blocked for a specific period to avoid overwhelming the failing service.  
3️⃣ **Half-Open State** – A few test requests are allowed to see if the service has recovered.  
   - If successful, it transitions back to the Closed State; otherwise, it remains Open.  

### 🔹 Tools to Implement Circuit Breaker:

💡 **Hystrix (by Netflix)**: A widely used library for fault tolerance.  
💡 **Resilience4j**: A lightweight alternative for Java-based applications.  

### 🔹 Real-World Examples:

#### Example 1: Netflix 🎥
Netflix uses the Circuit Breaker Pattern (with Hystrix) to ensure smooth streaming.  
-> If the Recommendation Service fails, Netflix breaks the circuit and serves cached recommendations to avoid downtime and keep users engaged.  

#### Example 2: Uber 🚗
Uber applies the Circuit Breaker Pattern to maintain the reliability of its core services.  
-> If the Driver Matching Service experiences issues, Uber switches to a fallback system to match riders with nearby drivers based on cached location data.  

This avoids delays and improves user experience even during service failures.  

### 🔹 Key Takeaways:

✅ Circuit Breaker ensures your application stays resilient.  
✅ Tools like Hystrix and Resilience4j simplify implementation.  
✅ Always have a fallback strategy to handle failures gracefully. 

## Service Discovery
### 🔹 Why Use Service Discovery?
In a microservices architecture, services communicate with each other over a network. Managing service locations manually becomes difficult because:

**Dynamic Scaling**: Services may scale up or down dynamically, leading to frequent changes in IP addresses or ports.  
**Service Failure**: A service instance might fail, and others need to take over.  
**Deployment Across Environments**: Services may be deployed across different regions, environments (e.g., dev, QA, production), or cloud platforms.  

**Service Discovery** automates the process of locating services so they can communicate efficiently without manual configuration.

---

### 🔹 How Does Service Discovery Work?
Service discovery can be implemented in two ways:

#### 1️⃣ Client-Side Service Discovery:
- Clients are responsible for discovering the service's location.  
- The client queries a **Service Registry** to fetch the available service instances and load-balances the requests.  
- **Example Flow**: The client contacts the **Service Registry** ➞ fetches the IP and port of a service ➞ calls the appropriate service instance.  
- **Tools**: Eureka, Consul, or ZooKeeper.  

#### 2️⃣ Server-Side Service Discovery:
- The service registry integrates with a **load balancer** (e.g., NGINX, HAProxy) to distribute requests.  
- The client makes requests to a fixed endpoint, and the load balancer fetches service details from the service registry to forward the request to the correct instance.  
- **Example Flow**: The client sends a request to the load balancer ➞ load balancer queries the **Service Registry** ➞ routes the request to an appropriate instance.  
- **Tools**: AWS ALB, Kubernetes Services, or F5 Load Balancer.  

---

### 🔹 Tools for Service Discovery
Here are popular tools used for implementing Service Discovery:

#### **Eureka (Netflix)**
- A popular client-side service discovery tool.  
- Eureka Server acts as a **Service Registry** where services register themselves.  
- Eureka Client enables services to discover other services dynamically.  

#### **Consul (by HashiCorp)**
- Supports both **service discovery** and **health checks**.  
- Provides key-value storage for configuration and works well in distributed environments.  

#### **Kubernetes Service Discovery**
- In Kubernetes, services are discovered using **DNS** or environment variables.  
- Kubernetes automatically tracks the IPs of pods and exposes services dynamically.  

#### **ZooKeeper**
- An older but reliable solution for service discovery and distributed coordination.  
- Used in Apache Kafka for managing brokers.  

#### **AWS Cloud Map**
- A fully managed service discovery solution that allows services to register and discover across AWS environments.  

---

### 🔹 Real-World Examples

#### 1️⃣ **Netflix** 🎥
- Netflix uses **Eureka** for client-side service discovery.  
- Each microservice registers itself with the **Eureka Server**, and other services discover the instances dynamically.  

#### 2️⃣ **Uber** 🚗
- Uber uses **Consul** for service discovery.  
- Consul ensures that when a service instance is added, removed, or fails, its state is updated in real-time, and healthy instances are discovered quickly.  

#### 3️⃣ **Spotify** 🎵
- Spotify uses **Kubernetes** for managing and discovering microservices.  
- Services register as Kubernetes Pods, and **Kubernetes Services** expose endpoints dynamically.  

#### 4️⃣ **Amazon** 🌐
- Amazon leverages **AWS Cloud Map** for service discovery across its infrastructure.  
- Services running on **EC2**, **ECS**, or **Lambda** can be registered and discovered seamlessly.  

---

### 🔹 Key Takeaways

✅ **Service Discovery** ensures seamless communication between microservices in dynamic environments.  
✅ Choose **client-side** or **server-side discovery** based on architecture needs.  
✅ Tools like **Eureka**, **Consul**, and **Kubernetes** simplify implementation.  
✅ Real-world giants like **Netflix**, **Uber**, and **Amazon** rely on service discovery to maintain system scalability and resilience.

# API Gateway

The **API Gateway Microservices Pattern** is a design pattern that provides a single entry point for clients to interact with a set of microservices in a system. It acts as a reverse proxy, routing requests from clients to the appropriate backend microservices. This pattern helps in managing cross-cutting concerns such as security, logging, load balancing, authentication, and request aggregation.

## Why Use the API Gateway Microservices Pattern?

The **API Gateway** pattern is employed for several reasons, particularly when dealing with microservices architectures:

### Simplification of Client Communication:
In a microservices architecture, clients would otherwise need to interact with each individual service. The API Gateway abstracts this complexity, providing a single entry point for clients. This simplifies interactions with the system.

### Centralized Cross-Cutting Concerns:
Common features like logging, authentication, authorization, rate limiting, monitoring, and caching can be centralized in the API Gateway, making them easier to manage and apply consistently across the system.

### Decoupling of Clients and Microservices:
Clients don’t need to be aware of or tightly coupled to the individual services; they interact with the API Gateway, which handles routing to the services. This reduces the potential impact of changes in microservices on clients.

### Performance Improvements:
The API Gateway can aggregate responses from multiple services and reduce the number of calls that clients need to make, thus improving client-side performance. It can also cache responses to reduce redundant computations.

### Load Balancing and Scalability:
The API Gateway can distribute traffic across multiple instances of microservices, ensuring high availability and better load distribution.

## How the API Gateway Pattern Works:

1. **Request Handling**: Clients send requests to the API Gateway, which acts as a reverse proxy.
   
2. **Routing and Load Balancing**: The Gateway routes these requests to the appropriate microservices based on the request path or content.

3. **Aggregation**: For requests requiring data from multiple microservices, the API Gateway can aggregate responses before sending them back to the client, minimizing round trips.

4. **Authentication and Authorization**: The Gateway checks the security credentials (e.g., JWT tokens) and enforces authorization rules before routing the request to the appropriate service.

5. **Cross-Cutting Concerns**: It can handle other concerns such as logging, rate limiting, caching, and monitoring, allowing microservices to remain focused on their specific functionality.

## Tools and Technologies:

- **AWS API Gateway**: A fully managed API Gateway service from AWS that enables you to create, deploy, and manage APIs. It handles traffic management, authorization and access control, monitoring, and API versioning.
  
- **Kong**: An open-source API Gateway and microservices management layer that provides features like load balancing, security (OAuth, JWT), rate limiting, and monitoring. It is highly extensible via plugins.
  
- **Zuul**: A JVM-based API Gateway from Netflix that supports dynamic routing, monitoring, and security. It integrates well with microservices based on Spring Boot.

- **NGINX**: A high-performance web server and reverse proxy that is commonly used as an API Gateway. It can handle load balancing, HTTP caching, and SSL termination.

- **Traefik**: An open-source HTTP reverse proxy and load balancer designed for microservices. It integrates with Kubernetes and provides automatic service discovery and dynamic configuration.

- **Spring Cloud Gateway**: A non-blocking API Gateway built on Spring Framework, designed for cloud-native microservices. It provides routing, load balancing, and security features.

## Real-World Examples:

- **Amazon**:
  Amazon uses an API Gateway to centralize access to its microservices, enabling secure and scalable communication between clients and services like inventory management, payments, and shipping.
  
- **Netflix**:
  Netflix uses Zuul as its API Gateway to handle dynamic routing, authentication, and load balancing. It also aggregates responses from various services and provides security features for clients accessing the content.
  
- **Uber**:
  Uber uses API Gateways to manage and expose multiple microservices related to ride requests, payment processing, and location-based services. The Gateway helps Uber efficiently handle high volumes of requests and manage security across their platform.
  
- **Spotify**:
  Spotify leverages API Gateway architecture to route requests from users (e.g., to play music, manage playlists) to different microservices such as account management, playback services, and recommendations. It also helps scale the platform and manage cross-cutting concerns.

## Key Takeaways:

- **Simplifies Client-Server Communication**: The API Gateway abstracts the complexity of dealing with multiple microservices, offering a single entry point for clients to interact with.

- **Centralized Management**: It enables centralized handling of cross-cutting concerns such as authentication, security, logging, monitoring, rate limiting, and caching.

- **Improved Performance and Scalability**: By aggregating responses, caching, and load balancing, the API Gateway improves performance and ensures the scalability of services.

- **Decouples Clients from Microservices**: Clients don’t need to be aware of service details, which makes the system more flexible and easier to maintain.

- **Single Point of Failure Consideration**: While it centralizes access, the API Gateway also introduces a single point of failure. Proper failover strategies and redundancy are needed to mitigate this risk.

- **Choice of Tools**: There are several tools and platforms available for implementing API Gateways, each suited to different needs (e.g., AWS API Gateway for fully managed services, Kong for flexibility, Zuul for JVM-based apps).

The **API Gateway** pattern is particularly effective in simplifying interactions in microservices architectures, offering centralized management and improving both scalability and performance. However, it’s important to be aware of the challenges related to performance bottlenecks and single points of failure.

## Retry Pattern
... Content about Retry Pattern ...

## Bulkhead
... Content about Bulkhead ...

## Saga Pattern
... Content about Saga Pattern ...

## Event-Driven Architecture
... Content about Event-Driven Architecture ...

## Strangler Fig
... Content about Strangler Fig ...

