# ETABS - Expense Tracking & Budgeting System

ETABS is a console-based financial management application built in Java. It is designed to take unstructured daily spending habits and organize them into clear, actionable financial insights through categorization, budget tracking, and persistent local storage.

> "Turn chaos into cash."

---

## 🛠️ Tech Stack & Concepts
* **Language:** Java (JDK 11+)
* **Core Concepts:** Parallel Array Architectures, Text-Based File I/O Streams, Input Validation, and Exception Handling.

---

## 🚀 Key Features

The application operates via an interactive, 9-option command-line menu:

* **User Profile Setup:** Captures basic user metadata (Name, Occupation, Income) on startup and automatically projects annualized revenue.
* **Expense Tracking (Option 1):** Logs individual transactions with descriptions, precise amounts, dates (`DD-MM-YYYY`), and specific categories (e.g., housing, groceries, utilities).
* **Dual-Stream Viewing (Option 2):** Displays logged expenses in a clean tabular format, sortable from latest-to-oldest or oldest-to-latest.
* **Financial Summaries (Option 3):** Generates overall spending summaries, identifies highest/lowest expenses, and filters data dynamically by specific months or years.
* **Cash Flow Analytics (Option 4):** Measures actual expenses against income to calculate remaining monthly and yearly balances, triggering warnings if you are running a deficit.
* **Obligatory Calculations (Option 5):** Automatically computes standard financial obligations, including a 2% income tax model and a 2.5% Zakat wealth contribution.
* **Budget Guardrails (Option 6):** Compares actual monthly and daily spending velocities against user-defined budget limits to provide real-time warning flags.
* **Automated Financial Advice (Option 7):** Scans historical data to isolate your highest-spending category and uses conditional logic to deliver targeted cost-cutting tips.
* **File Handling (Option 8):** Implements local file persistence (`Expenses.txt`) to save and load your financial data between application runs.

---

## 🧠 Defensive Programming & Engineering Insights

This section highlights the design choices made to ensure the application remains stable, fast, and resilient against runtime crashes.

### 🛡️ Defensive Architecture (Crash Prevention)
* **Robust Input Validation:** Standard console inputs are wrapped in `try-catch` structures. If a user enters text where a numerical value is expected, the application intercepts the `InputMismatchException` gracefully and prompts them to try again instead of crashing.
* **Array Bounds Protection:** Because the application utilizes fixed-size arrays with a limit of 100 entries, the system explicitly validates the tracking index *before* inserting data, preventing `ArrayIndexOutOfBoundsException` errors.
* **Data Integrity Checks:** When parsing data from `Expenses.txt`, the deserialization logic validates the structure of the comma-separated string lines before pushing them back into active memory.

### ⚙️ Engineering Design (Data Handling)
* **Parallel Array Alignment:** Transaction data is managed across structurally synchronized arrays (`description`, `amount`, `category`, `date`) tied together by a single index counter.
* **Linear Performance ($O(n)$):** Search and filter logic—such as isolating the highest expense or calculating monthly sums—runs via clean, single-pass loops, ensuring predictable execution speed.
* **State Persistence:** A dedicated file I/O layer handles simple serialization, allowing runtime application data to move seamlessly between memory (RAM) and local disk storage.

---

## 💻 How to Run

This application relies strictly on standard Java libraries and has zero external dependencies.

### Prerequisites
* Java Development Kit (JDK) 11 or higher installed.

### Steps

1. Clone the Repository

Open your terminal or command prompt and run:

```bash
git clone https://github.com/Mehreen-Mitha/Hospital-Management-System.git
```

2. Navigate to the Project Folder

```bash
cd Hospital-Management-System
```

3. Compile and Run

Depending on your project structure, use the appropriate commands. For example:

```bash
# If using javac
javac -d bin src/*.java
java -cp bin MainClassName
```

> **Note:** If you are using an IDE such as IntelliJ IDEA, Eclipse, or VS Code, you can simply select **Open Project** and choose the cloned folder. The IDE will automatically detect and configure the source code.
