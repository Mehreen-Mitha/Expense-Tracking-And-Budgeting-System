# ETABS - Expense Tracking & Budgeting System

A robust, console-based financial management application engineered in Java. ETABS transforms unstructured daily spending habits into structured financial insights by providing granular expense categorizations, real-time algorithmic financial advice, necessary tax/religious contribution evaluations, and persistent local storage.

> "Turn chaos into cash."

---

## 🛠️ Tech Stack & Technical Concepts

- **Language:** Java (JDK 11+)
- **Concepts Implemented:** Object-Oriented Design, Parallel Array Data Structuring, Text-based File I/O Streams, Algorithmic Decision-Making, Input Validation & Exception Handling.
- **Data Architecture:** Custom multi-array state tracking across descriptive indices with an upper bound limit of 100 historical datasets.

---

## 🚀 Fully Featured Financial Engine

ETABS provides a modular, 9-option interactive command-line interface. Here is a detailed breakdown of the capabilities built into the system:

### 1. User Profile Initialization
* **Dynamic Onboarding:** Captures user metadata upon boot, including Name, Occupation, and Monthly Income.
* **Annual Forecasting:** Programmatically projects annualized revenue margins based on baseline inputs (`yearlyIncome = monthlyIncome * 12`).

### 2. Comprehensive Expense Tracking (`Option 1`)
* **Granular Records:** Captures structured transactional information including a text description, chronological date (`DD-MM-YYYY`), and exact cost.
* **Categorization Engine:** Standardizes entries into strict lower-case categories for accurate downstream data evaluation (`housing`, `utilities`, `groceries`, `healthcare`, `dining`, `entertainment`, `shopping`, `travel`, `miscellaneous`).
* **Upper Bound Bounds-Checking:** Enforces a hard index limit of 100 entries to proactively mitigate memory saturation.

### 3. Dual-Stream Record Review (`Option 2`)
* **Latest-to-Oldest Stream:** Reverses the array traversal index pointers (`count - 1` down to `0`) to show users their most recent transactions first.
* **Oldest-to-Latest Stream:** Traverses indices sequentially to evaluate continuous spending behavior over time.
* **Tabular Formatting:** Utilizes clean string formatting templates (`%-20s %-10.2f...`) to build readable data columns directly inside the console interface.

### 4. Multi-Tiered Financial Summaries (`Option 3`)
* **Overall Metrics:** Scans historical arrays to track aggregate total expenses alongside the single highest and lowest transaction figures.
* **Targeted Calendrical Filters:** Parses chronological array data using custom string delimiters (`split("-")`) to isolate and evaluate specific months (`1-12`) or exact calendar years.
* **Categorical Matrix Reporting:** Sub-allocates spending values across all 9 distinct business categories for pinpointing financial leaks.

### 5. Cash Flow Revenue Analytics (`Option 4`)
* **Net Profit Margins:** Computes exact net-surplus positions by balancing baseline monthly/annual income profiles directly against total computed expenditure arrays.
* **Deficit Warnings:** Triggers high-visibility console flags (`** WARNING **`) if actual data states reveal that user outlays structurally exceed total asset baselines.

### 6. Obligatory Regulatory Computations (`Option 5`)
* **Tax Deduction Mapping:** Simulates automated public fiscal planning by rendering a steady 2% annualized dynamic income tax deduction model.
* **Zakat Assessment Subsystem:** Integrates direct cultural/religious asset evaluation algorithms by processing a precise 2.5% wealth contribution threshold against projected annual asset pools.

### 7. Algorithmic Budget Guardrails (`Option 6`)
* **Granular Scaling:** Breaks down target monthly allowances into exact proportional 30-day spending limits.
* **Contextual Concluding Feedback:** Programmatically compares actual spending velocities against ideal trajectories to deliver dynamic terminal feedback (ranging from "Good job, you're saving" to high-priority intervention warnings).

### 8. Real-Time Automated Financial Advisor (`Option 7`)
* **Highest-Impact Analysis:** Executes array scanning logic to isolate the single highest expenditure category across the entire dataset.
* **Dynamic Mitigation Strategies:** Evaluates findings via switch-case branching to supply custom, context-aware financial advice tailored to that specific category.

### 9. Flat-File Persistence Engine (`Option 8`)
* **State Serialization:** Couples `FileOutputStream` and `PrintWriter` to write system memory state configuration lines to a persistent local text block (`Expenses.txt`).
* **Automated State Restorations:** Re-initializes system indexes by reading files row-by-row via `FileInputStream`, breaking down tokens with clean regex parsing (`split(", ")`), and safely packing parameters back into system arrays.

---

## 🧠 Engineering Insights & Defensive Code Architecture

### 1. Robust Input Validation & Exception Handling
To ensure runtime stability against deliberate or unexpected user input failure, the core console engine encapsulates standard scanners within localized `try-catch` structures. For instance, trapping `InputMismatchException` instances ensures invalid characters passed to numerical prompts seamlessly trigger clean correction prompts instead of structural system crashes.

### 2. Multi-Context Parallel Storage Structures
Global data scopes manage transactional metadata through corresponding structural indices:
* `String[] description`
* `double[] amount`
* `String[] category`
* `String[] date`

This data model allows localized calculation loops across modules like `viewSummary()` and `financialAdvice()` to compute overall, monthly, or annualized metrics efficiently in $O(n)$ time complexity.

### 3. Deliberate Text Deserialization Parse Strategy
When managing localized text persistence via `fileHandling()`, the engine enforces a structured comma-separated-value (`", "`) design schema. When parsing data elements back into application memory, a programmatic length assertion guarantees elements pass an analytical size check before allocating memory arrays, mitigating potential index out-of-bounds corruption.

---

## 💻 How to Run (Local Compilation)

Because this application relies strictly on standard core Java libraries, it has zero external package dependencies.

### Prerequisites
* Java Development Kit (JDK) 11 or higher installed.

### Execution
1. **Clone the repository:**
   ```bash
   git clone [https://github.com/your-username/etabs.git](https://github.com/your-username/etabs.git)
   cd etabs
