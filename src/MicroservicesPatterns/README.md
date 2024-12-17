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

## API Gateway
... Content about API Gateway ...

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

