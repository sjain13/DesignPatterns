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
... Content about Circuit Breaker ...

## Service Discovery
... Content about Service Discovery ...

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

In a microservices architecture, failures are inevitable. But how do we stop one failure from cascading and impacting the entire system? 🔌 This is where the Circuit Breaker Pattern comes to the rescue! ⚡

🔹 What is the Circuit Breaker Pattern?

Just like an electrical circuit breaker, it “breaks” the connection to a failing service to prevent overload and allow the system to recover. It monitors requests and decides when to stop calls temporarily. 🛡️

🔹 Why Use Circuit Breakers?

✅ Prevent cascading failures.
✅ Ensure system resilience and uptime.
✅ Reduce unnecessary load on struggling or unavailable services.

🔹 How Does It Work?

1️⃣ Closed State – All requests are allowed until a threshold of failures is reached.
2️⃣ Open State – Requests are blocked for a specific period to avoid overwhelming the failing service.
3️⃣ Half-Open State – A few test requests are allowed to see if the service has recovered.
If successful, it transitions back to the Closed State; otherwise, it remains Open. 🔄

🔹 Tools to Implement Circuit Breaker :-

💡 Hystrix (by Netflix): A widely used library for fault tolerance.
💡 Resilience4j: A lightweight alternative for Java-based applications.

🔹 Real-World Example-1: 

Netflix 🎥

Netflix uses the Circuit Breaker Pattern (with Hystrix) to ensure smooth streaming.
-> If the Recommendation Service fails, Netflix breaks the circuit and serves cached recommendations to avoid downtime and keep users engaged.

🔹 Real-World Example - 2 :- 
Uber 🚗

Uber applies the Circuit Breaker Pattern to maintain the reliability of its core services.

-> If the Driver Matching Service experiences issues, Uber switches to a fallback system to match riders with nearby drivers based on cached location data.

This avoids delays and improves user experience even during service failures.

🔹 Key Takeaways:

✅ Circuit Breaker ensures your application stays resilient.
✅ Tools like Hystrix and Resilience4j simplify implementation.
✅ Always have a fallback strategy to handle failures gracefully.

