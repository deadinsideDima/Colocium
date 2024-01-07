#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <thread>
#include <mutex>
#include <memory>

// Интерфейс для операций
class Operation {
public:
    virtual float perform(const std::vector<float>& numbers) const = 0;
    virtual ~Operation() {}
};

// Конкретные реализации операций
class Addition : public Operation {
public:
    float perform(const std::vector<float>& numbers) const override {
        float result = 0.0f;
        for (float num : numbers) {
            result += num;
        }
        return result;
    }
};

class Multiplication : public Operation {
public:
    float perform(const std::vector<float>& numbers) const override {
        float result = 1.0f;
        for (float num : numbers) {
            result *= num;
        }
        return result;
    }
};

class SumOfSquares : public Operation {
public:
    float perform(const std::vector<float>& numbers) const override {
        float result = 0.0f;
        for (float num : numbers) {
            result += num * num;
        }
        return result;
    }
};

// Функция для чтения файла и выполнения операций
void processFile(const std::string& filename, std::mutex& mtx, float& sum) {
    std::ifstream inputFile(filename);
    if (inputFile.is_open()) {
        int action;
        inputFile >> action; // Чтение действия из первой строки файла

        std::string line;
        std::vector<float> numbers;

        // Чтение чисел из второй строки файла
        std::getline(inputFile, line); // Пропускаем символ новой строки после числа действия
        std::getline(inputFile, line);
        std::istringstream iss(line);
        float number;
        while (iss >> number) {
            numbers.push_back(number);
        }

        inputFile.close();

        // Выбор операции в зависимости от считанного действия
        std::shared_ptr<Operation> operation;
        switch (action) {
        case 1:
            operation = std::make_shared<Addition>();
            break;
        case 2:
            operation = std::make_shared<Multiplication>();
            break;
        case 3:
            operation = std::make_shared<SumOfSquares>();
            break;
        default:
            std::cerr << "Unknown action: " << action << " in file: " << filename << std::endl;
            return;
        }

        // Выполнение операции над числами из файла
        float result = operation->perform(numbers);

        // Захват мьютекса для безопасной записи в общую переменную
        std::lock_guard<std::mutex> lock(mtx);
        sum += result;
    }
    else {
        std::cerr << "Unable to open file: " << filename << std::endl;
    }
}


int main(int argc, char* argv[]) {
    if (argc < 3) {
        std::cout << "Usage: " << argv[0] << " <directory_path> <num_threads>" << std::endl;
        return 1;
    }

    std::string directoryPath = argv[1];
    int numThreads = std::stoi(argv[2]);
    float sum = 0.0f;
    std::mutex mtx;
    std::vector<std::thread> threads;

    for (int i = 1; i <= numThreads; ++i) {
        std::string filename = directoryPath + "/in_" + std::to_string(i) + ".dat";
        threads.emplace_back(processFile, filename, std::ref(mtx), std::ref(sum));
    }

    // Дождитесь завершения всех потоков
    for (std::thread& thread : threads) {
        thread.join();
    }

    // Запись результата в файл out.dat
    std::ofstream outputFile(directoryPath + "/out.dat");
    if (outputFile.is_open()) {
        outputFile << sum << std::endl;
        outputFile.close();
        std::cout << "Result written to out.dat" << std::endl;
    }
    else {
        std::cerr << "Unable to open output file." << std::endl;
        return 1;
    }

    return 0;
}

