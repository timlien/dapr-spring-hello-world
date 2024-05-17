## Dapr Spring Hello World

This project is a Spring Boot Hello World App for Dapr. It provides a way to interact with Dapr from Spring Boot applications.

### Prerequisites

- Kubernetes cluster
- Dapr installed on kubernetes cluster
 
### Getting Started

To install the application you only need to run the following command

```bash
kubectl apply -f k8s/
```

To avoid dealing with Ingresses you can access the application by using kubectl port-forward, run to access the application on port 8080:

```bash
kubectl port-forward service/hello-service 8090:80
```

Then you can access "Hello, World!" by running:

```bash
curl http://localhost:8090/hello
```

Delete the application by running:

```bash
kubectl delete -f k8s/
```


