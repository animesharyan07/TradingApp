# ⚡ Energy Trading CLI (Java + PostgreSQL)

A simple **Command-Line Application** for managing energy trades such as Power, Gas, and Oil.  
This project demonstrates integration of **Java** with a **PostgreSQL database** to store and manage trade records.

---

## 📌 Features
- Create, Read, Update, and Delete (CRUD) trades.
- PostgreSQL-backed persistence for trades.
- Simple CLI interface for interacting with the system.
- Supports multiple commodities (Power, Gas, Oil, etc.).
- Differentiates between **BUY** and **SELL** trades.

---

## 🛠️ Tech Stack
- **Java** (JDK 17 or above recommended)
- **PostgreSQL** (v12+)
- **JDBC** for database connectivity


---

## 📂 Project Structure
- src/
└── App.java # Main entry point
└── User.java
└── UserDAO.java
└── DataBaseConnection.java
lib/
└── postgresql-42.7.7.jar
