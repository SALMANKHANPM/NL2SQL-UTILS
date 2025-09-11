import matplotlib.pyplot as plt
import seaborn as sns
import pandas as pd

# Sample data (replace with your own metrics)
data = {
    "Models": ["GPT-OSS-20B-Q8-Default", "GPT-OSS-20B-Q4-Low", "GPT-OSS-20B-Q4-Medium", "GPT-OSS-20B-Q4-High", "Qwen3-30B-A3B-Instruct-Q4", "Qwen3-30B-A3B-Thinking-Q4KM", "Qwen3-Coder-30B-A3B-Q4KM", "Qwen3-Coder-30B-A3B-Q8KXL", "Qwen2.5-Coder-Arctic-32B-Q4KM"],
    "Ex": [43.40, 38.0, 43.60, 43.20, 45.60, 53.20,47.40, 48.00, 44.20],
    "R-Ves": [41.69, 36.75, 41.89, 41.03, 44.17,51.99, 46.03, 46.33, 42.86],
    "Soft F1": [47.85, 42.52, 48.71, 47.50, 48.60, 56.39, 51.15, 51.98, 47.58],
}

avg = {"Avg": [sum(x) / len(x) for x in zip(data["Ex"], data["R-Ves"], data["Soft F1"])]}
df = pd.DataFrame(data).assign(**avg).sort_values(by="Avg", ascending=False)
df = df.set_index("Models")

# Plotting
plt.figure(figsize=(10, 6))
df.plot(kind='bar')
plt.title("Model Performance on MiniDev Benchmark")
plt.ylabel("Accuracy (%)")
plt.xlabel("Model")
plt.xticks(rotation=15)
plt.ylim(0, 100)
plt.grid(True, linestyle='--', alpha=0.5)
plt.legend(title="Benchmark")
plt.tight_layout()
plt.show()