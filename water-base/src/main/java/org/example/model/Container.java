package org.example.model;

import org.example.service.ContainerService;

public class Container implements ContainerService {
    Container[] g;
    int n;
    private double amount;

    public Container() {
        g = new Container[1000];
        g[0] = this;
        n = 1;
        amount = 0;
    }

    public void connectTo(Container other) {
        double z = (amount * n + other.amount * other.n) / (n + other.n);

        for (int i = 0; i < n; i++) // for each container g[i] in first group
            for (int j = 0; j < other.n; j++) { // for each container c.g[j] in second group
                g[i].g[n + j] = other.g[j]; // add second to group of first
                other.g[j].g[other.n + i] = g[i]; // add first to group of second
            }

        n += other.n;

        for (int i = 0; i < n; i++) {
            g[i].n = n;
            g[i].amount = z;
        }
    }

    public void addWater(double amount) {
        double y = amount / n;
        for (int i = 0; i < n; i++)
            g[i].amount = g[i].amount + y;
    }

    public double getAmount() {
        return amount;
    }
}
