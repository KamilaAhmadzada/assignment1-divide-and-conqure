import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("results/results.csv")

algorithms = df["algorithm"].unique()

# Plot 1: Time vs. n (averaged across input types)
plt.figure(figsize=(8, 5))
for algo in algorithms:
    subset = df[df["algorithm"] == algo]
    grouped = subset.groupby("size")["timeMs"].mean()
    plt.plot(grouped.index, grouped.values, marker="o", label=algo)

plt.xlabel("Input size (n)")
plt.ylabel("Time (ms)")
plt.title("Execution Time vs. Input Size")
plt.legend()
plt.grid(True)
plt.savefig("docs/plots/time_vs_n.png")
plt.close()

# Plot 2: Recursion depth vs. n (averaged across input types)
plt.figure(figsize=(8, 5))
for algo in algorithms:
    subset = df[df["algorithm"] == algo]
    grouped = subset.groupby("size")["maxDepth"].mean()
    plt.plot(grouped.index, grouped.values, marker="o", label=algo)

plt.xlabel("Input size (n)")
plt.ylabel("Max recursion depth")
plt.title("Recursion Depth vs. Input Size")
plt.legend()
plt.grid(True)
plt.savefig("docs/plots/depth_vs_n.png")
plt.close()

print("Plots saved to docs/plots/")