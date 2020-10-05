import UIKit
import NatDS

final class NativeIconographyViewController: UIViewController {
    private let icons: [Icon] = Icon.allCases

    private lazy var collectionView: UICollectionView = {
        let layout = UICollectionViewFlowLayout()
        layout.sectionInset = UIEdgeInsets(top: 8, left: 16, bottom: 16, right: 16)
        layout.itemSize = CGSize(width: ((UIScreen.main.bounds.width) / 2) - 32, height: 100)

        let collectionView = UICollectionView(frame: .zero, collectionViewLayout: layout)
        collectionView.collectionViewLayout = layout
        collectionView.dataSource = self
        collectionView.register(IconCollectionViewCell.self)
        collectionView.backgroundColor = .clear
        collectionView.translatesAutoresizingMaskIntoConstraints = false

        return collectionView
    }()

    override func viewDidLoad() {
        super.viewDidLoad()

        title = "Native Iconography"
        setup()
    }

    private func setup() {
        view.backgroundColor = NatColors.background
        view.addSubview(collectionView)

        NSLayoutConstraint.activate([
            collectionView.topAnchor.constraint(equalTo: view.topAnchor),
            collectionView.rightAnchor.constraint(equalTo: view.rightAnchor),
            collectionView.bottomAnchor.constraint(equalTo: view.bottomAnchor),
            collectionView.leftAnchor.constraint(equalTo: view.leftAnchor)
        ])
    }
}

extension NativeIconographyViewController: UICollectionViewDataSource {

    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        icons.count
    }

    func collectionView(_ collectionView: UICollectionView,
                        cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let view = collectionView.dequeueReusableCell(for: indexPath, cellType: IconCollectionViewCell.self)

        view.icon = icons[indexPath.row]
        return view
    }
}
