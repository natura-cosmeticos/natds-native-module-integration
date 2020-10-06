import UIKit
import NatDS

class IconsPlataformChoiceViewController: UIViewController {
    private let nativeButton: NatButton = {
        let button = NatButton(style: .contained)
        button.configure(title: "Native")
        button.translatesAutoresizingMaskIntoConstraints = false

        return button
    }()

    private let reactivenativeV1Button: NatButton = {
        let button = NatButton(style: .contained)
        button.configure(title: "Reactive Native v1")
        button.translatesAutoresizingMaskIntoConstraints = false

        return button
    }()

    private let reactivenativeV2Button: NatButton = {
        let button = NatButton(style: .contained)
        button.configure(title: "Reactive Native v2")
        button.translatesAutoresizingMaskIntoConstraints = false

        return button
    }()

    override func viewDidLoad() {
        super.viewDidLoad()

        setup()

        nativeButton.addTarget(self, action: #selector(nativeButtonTapHandler), for: .touchUpInside)
     }

    @objc func nativeButtonTapHandler() {
        let viewController = NativeIconographyViewController()
        navigationController?.pushViewController(viewController, animated: true)
    }

    private func setup() {
        view.backgroundColor = NatColors.background

        view.addSubview(nativeButton)
        view.addSubview(reactivenativeV1Button)
        view.addSubview(reactivenativeV2Button)

        addConstraints()
    }

    private func addConstraints() {
        let constraints = [
            nativeButton.bottomAnchor.constraint(equalTo: reactivenativeV1Button.topAnchor, constant: -NatSpacing.small),
            nativeButton.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            nativeButton.widthAnchor.constraint(equalToConstant: NatSizes.hugeXXX),
            nativeButton.heightAnchor.constraint(equalToConstant: NatButton.Height.medium),

            reactivenativeV1Button.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            reactivenativeV1Button.centerYAnchor.constraint(equalTo: view.centerYAnchor),
            reactivenativeV1Button.widthAnchor.constraint(equalToConstant: NatSizes.hugeXXX),
            reactivenativeV1Button.heightAnchor.constraint(equalToConstant: NatButton.Height.medium),

            reactivenativeV2Button.topAnchor.constraint(equalTo: reactivenativeV1Button.bottomAnchor, constant: NatSpacing.small),
            reactivenativeV2Button.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            reactivenativeV2Button.widthAnchor.constraint(equalToConstant: NatSizes.hugeXXX),
            reactivenativeV2Button.heightAnchor.constraint(equalToConstant: NatButton.Height.medium)
        ]

        NSLayoutConstraint.activate(constraints)
    }
}

