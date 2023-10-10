package org.example.service;

import org.example.model.Container;

public interface ContainerService {
    void connectTo(Container other);

    void addWater(double amount);
}
