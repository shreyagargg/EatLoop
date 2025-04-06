# User FlowChart

```mermaid
graph TD;
    A[Start/Hello] --> B{Is Login?};
    B --> Z[Yes] --> I
    B --> Y[No]

    Y --> G[Enter name, password] --> H[Enter address];
    H --> I[Welcome to EatLoop]
    I --> C[Want to order something ?];
    I --> D[Info about order] --> N[Delivery Status] --> O[If delivered -> OTP]
    I --> E[History] --> P[History with payment method, food , price, restaurant]
    I --> F[Wants to update address] --> Q[New Address]

    C --> J[Search by food/ Restaurant]
    J -- Yes --> K[Time, price etc. Add to cart] --> L[Payment Method] --> M[Payment valid or not]
    J -- No --> R[not available]
    
```

# Restaurant FlowChart

```mermaid
graph TD;
    A[Start/Hello] --> B{Is Registered?};
    B --> Z[Yes] --> I
    B --> Y[No]
    Y --> G[Verified Yourself];

    G --> I[Welcome to EatLoop]

    I --> E[History]
    E --> c[1 day history]
    E --> d[Complete history]

    I --> F[Wants to update menu]
    F --> Q[Add food, price etc]
    F --> R[Delete food/Change price etc]

    I --> J[Orders Status]
    J --> K[Order Pending] --> M[List of orders]
    M --> O[Accept/Reject] --> P[Notification to eatloop]
    J --> L[Order Delivered] --> N[history and feed back]
    J --> S[Order ready for Delivered] --> H[OTP for eatloop and delivery person]


