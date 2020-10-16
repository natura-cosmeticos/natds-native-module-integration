import UIKit
import NatDS

class IconCollectionViewCell: UICollectionViewCell {
    var icon: Icon? {
        didSet {
            iconView.icon = icon
            label.text = icon?.rawValue
        }
    }

    private let stackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.translatesAutoresizingMaskIntoConstraints = false

        return stackView
    }()

    private let iconView: IconView = {
        let iconView = IconView(fontSize: NatSizes.semi)
        iconView.tintColor = NatColors.highEmphasis

        return iconView
    }()

    private let label: UILabel = {
        let label = UILabel()
        label.textAlignment = .center
        label.tintColor = NatColors.highEmphasis
        label.font = NatFonts.font(ofSize: .caption)

        return label
    }()

    override init(frame: CGRect) {
        super.init(frame: frame)
        setup()
    }

    @available(*, unavailable)
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }

    func setup() {
        addSubview(stackView)

        stackView.addArrangedSubview(iconView)
        stackView.addArrangedSubview(label)

        NSLayoutConstraint.activate([
            stackView.topAnchor.constraint(equalTo: topAnchor, constant: 20),
            stackView.rightAnchor.constraint(equalTo: rightAnchor),
            stackView.bottomAnchor.constraint(equalTo: bottomAnchor),
            stackView.leftAnchor.constraint(equalTo: leftAnchor)
        ])
    }
}
